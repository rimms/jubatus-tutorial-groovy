import us.jubat.classifier.*

// set_config
def set_config(config, client) {
  def fv_config = new ConfigData();
  fv_config.method = config.ml_config.method
  fv_config.config = config.ml_config.fv_config

  client.set_config(config.name, fv_config)
}

// train
def train(config, client) {
  def train_file = new File('train.dat')

  train_file.eachLine { line ->
    def label = line.split(',')[0]
    def data = new File(line.split(',')[1]).text

    def string_value = new TupleStringString()
    string_value.first = 'message'
    string_value.second = data

    def datum = new Datum()
    datum.num_values = []
    datum.string_values = [string_value]

    def train_datum = new TupleStringDatum()
    train_datum.first = label
    train_datum.second = datum

    client.train(config.name, [train_datum])
  }
}

// analyze
def analyze(config, client) {
  def test_data = new File('test.dat')

  test_data.eachLine { line ->
    def label = line.split(',')[0]
    def data = new File(line.split(',')[1]).text

    def string_value = new TupleStringString()
    string_value.first = 'message'
    string_value.second = data

    def datum = new Datum()
    datum.num_values = []
    datum.string_values = [string_value]

    def answers = client.classify(config.name, [datum])
    def answer = get_most_likely(answers)

    printf '%5s - label: %s, answer: %s\n', true ? label == answer : false, label, answer
  }
}

def get_most_likely(answers) {
  def answer_prob = 0.0
  def answer_label = ''
  answers[0].each { answer ->
    if (answer_prob < answer.prob) {
      answer_prob = answer.prob
      answer_label = answer.label
    }
  }
  return answer_label
}

def config = new ConfigSlurper().parse(new File('config.groovy').toURL())
def client = new ClassifierClient(config.host, config.port, config.timeout)

set_config(config, client)
train(config, client)
analyze(config, client)
