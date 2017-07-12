/**
 * jspice is distributed under the GNU General Public License version 3
 * and is also available under alternative licenses negotiated directly
 * with Knowm, Inc.
 *
 * Copyright (c) 2016-2017 Knowm Inc. www.knowm.org
 *
 * Knowm, Inc. holds copyright
 * and/or sufficient licenses to all components of the jspice
 * package, and therefore can grant, at its sole discretion, the ability
 * for companies, individuals, or organizations to create proprietary or
 * open source (even if not GPL) modules which may be dynamically linked at
 * runtime with the portions of jspice which fall under our
 * copyright/license umbrella, or are distributed under more flexible
 * licenses than GPL.
 *
 * The 'Knowm' name and logos are trademarks owned by Knowm, Inc.
 *
 * If you have any questions regarding our licensing policy, please
 * contact us at `contact@knowm.org`.
 */
package org.knowm.jspice.circuits;

import org.knowm.jspice.component.Component;
import org.knowm.jspice.component.element.linear.Resistor;
import org.knowm.jspice.component.element.reactive.Capacitor;
import org.knowm.jspice.component.source.DCVoltage;
import org.knowm.jspice.component.source.Source;
import org.knowm.jspice.netlist.Netlist;

/**
 * @author timmolter
 */
public class V1R1C1 extends Netlist {

  /**
   * Constructor
   */
  public V1R1C1() {

    // define voltage source
    Source dcVoltageSource = new DCVoltage("V1", 0.0);

    // define resistor
    Component resistor1 = new Resistor("R1", 160000);

    // define capacitor
    Capacitor capacitor1 = new Capacitor("C1", 16E-8);
    capacitor1.setInitialCondition(0.6);

    // build netlist, the nodes can be named anything except for ground whose node is always labeled "0"
    addNetListComponent(dcVoltageSource, "1", "0");
    addNetListComponent(resistor1, "1", "2");
    addNetListComponent(capacitor1, "2", "0");
  }
}
