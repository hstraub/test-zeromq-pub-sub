package at.linuxhacker.zeromq

import org.zeromq.ZMQ

object PsenvSub {
  def main(args : Array[String]) {

    // Prepare our context and subscriber
    val context = ZMQ.context(1)
    val subscriber = context.socket(ZMQ.SUB)

    subscriber.connect("tcp://localhost:5563")
    subscriber.subscribe("B".getBytes())
    println( "Enter loop")
    while (true) {
      // Read envelope with address
      val address = new String(subscriber.recv(0))
      // Read message contents
      val contents = new String(subscriber.recv(0))
      println(address + " : " + contents)
    }
  }
}