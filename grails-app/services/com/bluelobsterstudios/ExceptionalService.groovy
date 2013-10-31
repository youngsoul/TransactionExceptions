package com.bluelobsterstudios

import grails.transaction.Transactional

@Transactional
class ExceptionalService {

    def checkedException() {

      new Thing(name: "checked exception thing").save(flush:true, failOnError: true)

      throw new Exception("Checked Exception!")
    }

  def uncheckedException() {
    new Thing(name: "unchecked exception thing").save(flush:true, failOnError: true)
    throw new RuntimeException("Runtime Exception!")
  }
}
