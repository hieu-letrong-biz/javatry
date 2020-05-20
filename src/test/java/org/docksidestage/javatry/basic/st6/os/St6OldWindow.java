package org.docksidestage.javatry.basic.st6.os;

/**
 * @author hieu
 */
public class St6OldWindow extends St6OperationSystem {

    // ===================================================================================
    //                                                                      Constructor
    //                                                                      ==============
    public St6OldWindow(String loginId) {
        super(loginId);
    }

    // ===================================================================================
    //                                                                      User Directory
    //                                                                      ==============
    @Override
    protected String getFileSeparator() {
        return "\\";
    }

    @Override
    protected String getUserDirectory() {
        return "/Documents and Settings/" + this.getLoginId();
    }
}
