package com.codersbistro.soapexample

import com.codersbistro.soapexample.generated.Address
import com.codersbistro.soapexample.generated.`package`.defaultScope

/**
  * Created by loveh on 6/4/2017.
  */
object Main {
  def main(args: Array[String]): Unit = {
    /*Example showing conversion of scala case classes to XML*/
    val addressXML =
      <shipTo xmlns="http://www.example.com/IPO">
        <name>Foo</name>
        <street>1537 Paper Street</street>
        <city>Wilmington</city>
      </shipTo>
    val parsedAddress = scalaxb.fromXML[Address](addressXML)
    println(s"Rendered XML case class is :: ${parsedAddress}")

    /*Example showing conversion of scala case classes to XML*/
    val newAddress = Address(
      name = "221B",
      street = "Bakers Street",
      city = "London"
    )
    val renderedXML = scalaxb.toXML[Address](newAddress, "ShippedTo", defaultScope)
    println(s"Generated XML is :: ${renderedXML}")
  }
}
