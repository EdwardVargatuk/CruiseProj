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
    TOORDER{
        {
            this.command= new OrderPageCommand();
        }
    },
    CONFIRMORDER{
        {
            this.command= new ConfirmOrderCommand();
        }
    },
    HOME{
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
