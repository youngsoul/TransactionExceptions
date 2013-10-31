package com.bluelobsterstudios

class ExceptionalController {

  ExceptionalService exceptionalService

    def index() { }

  /**
   * note that a checked exception will NOT roll back the transaction
   */
  def checked() {

    try {
      exceptionalService.checkedException()
    } catch (Throwable t) {
      println("ExceptionalController checked caught exception: ${t.message}")
    } finally {
      // note that the thing was saved
      def thingCount = Thing.count
      println "Number of Things: $thingCount"
      assert 1 == thingCount
      def l = Thing.list()
      Thing.deleteAll(l)
    }


  }

  def unchecked() {
    try {
      exceptionalService.uncheckedException()
    } catch (Throwable t) {
      println("ExceptionalController unchecked caught exception: ${t.message}")
    } finally {
      // note that the thing was saved
      def thingCount = Thing.count
      println "Number of Things: $thingCount"
      assert 0 == thingCount
    }

  }
}
