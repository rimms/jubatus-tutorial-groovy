jubatus-tutorial-groovy
=======================

- I ported `jubatus-tutorial-python <https://github.com/jubatus/jubatus-tutorial-python>`_ to groovy.
- See `Tutorial on Jubatus's official website <http://jubat.us/en/tutorial.html>`_ .
- This tutorial is using `Jubatus Java Client 0.4.1 <http://download.jubat.us/maven/us/jubat/jubatus/0.4.1/>`_ .

Requirements
------------
- Jubatus 0.4.2 or later
- Open Java Development Kit 6 update 27
- Gradle 1.4

How to Use
----------

::

  $ git clone git://github.com/rimms/jubatus-tutorial-groovy.git
  $ cd jubatus-tutorial-groovy
  $ wget http://people.csail.mit.edu/jrennie/20Newsgroups/20news-bydate.tar.gz
  $ tar xvzf 20news-bydate.tar.gz
  $ jubaclassifier --configpath config.json &
  $ gradle run

