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
package org.knowm.jspice.memristor;

import java.io.IOException;

import org.knowm.jspice.JSpice;
import org.knowm.jspice.netlist.Netlist;
import org.knowm.jspice.simulate.SimulationPlotter;
import org.knowm.jspice.simulate.SimulationResult;
import org.knowm.jspice.simulate.transientanalysis.TransientConfig;
import org.knowm.jspice.simulate.transientanalysis.driver.Square;

import io.dropwizard.configuration.ConfigurationException;

public class kTSynapse_FFXX {

  public static void main(String[] args) throws IOException, ConfigurationException {

//    go1();
    go2();
  }

  private static void go1() {

    Netlist netlist = new kTSynapse();

    String frequency = "100kHz";
    TransientConfig transientConfig = new TransientConfig("1000us", "500ns",
        new Square("VA", 0.25, "0", 0.25, frequency),
        new Square("VB", -0.25, "0", -0.25, frequency));
    netlist.setSimulationConfig(transientConfig);
    SimulationResult simulationResult = JSpice.simulate(netlist);
//    SimulationPlotter.plotAll(simulationResult);
//    SimulationPlotter.plot(simulationResult, "V(A)", "V(B)", "V(y)");
    SimulationPlotter.plot(simulationResult, "V(y)");
    SimulationPlotter.plot(simulationResult, "R(MA)", "R(MB)");

  }

  private static void go2() throws IOException, ConfigurationException {

    JSpice.simulate("FFXX-kTSynapse-netlist.cir");
  }

}
