jubatus-tutorial-groovy
=======================

- I ported `jubatus-tutorial-python <https://github.com/jubatus/jubatus-tutorial-python>`_ to groovy.
- See `Tutorial on Jubatus's official website <http://jubat.us/en/tutorial.html>`_ .
- This tutorial is using `Jubatus Java Client 0.5.x <http://download.jubat.us/maven/us/jubat/jubatus/>`_ .

Requirements
------------
- Jubatus 0.5.0 or later
- Gradle 1.11

How to Use
----------

::

  $ git clone git://github.com/rimms/jubatus-tutorial-groovy.git
  $ cd jubatus-tutorial-groovy
  $ wget http://people.csail.mit.edu/jrennie/20Newsgroups/20news-bydate.tar.gz
  $ tar xvzf 20news-bydate.tar.gz
  $ jubaclassifier --configpath config.json &
  $ gradle run

