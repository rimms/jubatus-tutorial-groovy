import us.jubat.classifier.*
import us.jubat.common.*

// train
def train(client) {
  def train_file = new File('train.dat')

  train_file.eachLine { line ->
    def label = line.split(',')[0]
    def data = new File(line.split(',')[1]).text

    def datum = new Datum().addString("message", data)
    def train_datum = new LabeledDatum(label, datum)

    client.train([train_datum])
  }
}

// analyze
def analyze(client) {
  def test_data = new File('test.dat')

  test_data.eachLine { line ->
    def label = line.split(',')[0]
    def data = new File(line.split(',')[1]).text

    def datum = new Datum().addString("message", data)

    def answers = client.classify([datum])
    def answer = get_most_likely(answers)

    printf '%5s - label: %s, answer: %s\n', true ? label == answer : false, label, answer
  }
}

def get_most_likely(answers) {
  def answer_score = 0.0
  def answer_label = ''
  answers[0].each { answer ->
    if (answer_score < answer.score) {
      answer_score = answer.score
      answer_label = answer.label
    }
  }
  return answer_label
}

def url = ClassLoader.getSystemResource('config.groovy')
def config = new ConfigSlurper().parse(url)
def client = new ClassifierClient(config.host, config.port, config.name, config.timeout)

train(client)
analyze(client)

System.exit(0)
