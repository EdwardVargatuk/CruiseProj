package controllers.servlets.command;

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
    MYORDER{
        {
            this.command = new MyOrderCommand();
        }
    },
    ADMINMENU{
        {
            this.command = new AdminMenuCommand();
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
