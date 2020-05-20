package org.docksidestage.bizfw.basic.objanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The object for raven(烏).
 * @author hieu
 */
public class Raven extends Animal implements Flyer{

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Logger logger = LoggerFactory.getLogger(Raven.class);

    @Override
    protected String getBarkWord() {
        return "Qua";
    }

    @Override
    public void fly() {
        logger.info("Fly to the sky...");
    }
}
