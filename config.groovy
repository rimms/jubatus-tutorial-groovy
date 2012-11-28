host    = '127.0.0.1'
port    = 9199
timeout = 0
name    = ''
ml_config {
  method    = 'PA'
  fv_config = """
    {
      "string_filter_types" : {
        "detag" : {
          "method"  : "regexp",
          "pattern" : "<[^>]*>",
          "replace" : ""
        }
      },
      "string_filter_rules" : [
        {
          "key"    : "message",
          "type"   : "detag",
          "suffix" : "-detagged"
        }
      ],
      "num_filter_types" : {},
      "num_filter_rules" : [],
      "string_types" : {},
      "string_rules" : [
        {
          "key"           : "message-detagged",
          "type"          : "space",
          "sample_weight" : "bin",
          "global_weight" : "bin"
        }
      ],
      "num_types" : {},
      "num_rules" : []
    }
  """
}
