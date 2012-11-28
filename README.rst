jubatus-tutorial-groovy
=======================

- I ported `jubatus-tutorial-python <https://github.com/jubatus/jubatus-tutorial-python>_` to groovy.
- See `Tutorial on Jubatus's official website <http://jubat.us/en/tutorial.html>_`

Requirements
------------
- Jubatus 0.3.4
- Open Java Development Kit 6 update 24
- Gradle 1.2

How to Use
----------

::

  $ git clone git://github.com/rimms/jubatus-tutorial-groovy.git
  $ cd jubatus-tutorial-groovy
  $ wget http://people.csail.mit.edu/jrennie/20Newsgroups/20news-bydate.tar.gz
  $ tar xvzf 20news-bydate.tar.gz
  $ jubaclassifier &
  $ gradle run

