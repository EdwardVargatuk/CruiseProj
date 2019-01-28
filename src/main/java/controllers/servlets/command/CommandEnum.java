package controllers.servlets.command;

/**
 * CommandEnum with all available command
 *
 * @author Edward
 */

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    TOURINFO {
        {
            this.command = new CruiseInfoCommand();
        }

    },
    TOORDER {
        {
            this.command = new OrderPageCommand();
        }
    },
    CONFIRMORDER {
        {
            this.command = new ConfirmOrderCommand();
        }
    },

    UPDATEORDER {
        {
            this.command = new UpdateOrderCommand();
        }
    },
    MYORDER {
        {
            this.command = new MyOrderCommand();
        }
    },
    VIEWORDERINFO {
        {
            this.command = new ViewOrderInfoCommand();
        }
    },
    ALLCLIENTS {
        {
            this.command = new AllClientsCommand();
        }
    },
    ALLORDERS {
        {
            this.command = new AllOrdersCommand();
        }
    },
    ALLCRUISES {
        {
            this.command = new AllCruisesCommand();
        }
    },
    EDITCRUISE {
        {
            this.command = new EditCruiseCommand();
        }
    },
    HOME {
        {
            this.command = new HomeCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
