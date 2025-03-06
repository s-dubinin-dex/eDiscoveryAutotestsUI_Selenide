package eDiscovery.testData;

public enum AdminPanelUsers {
    Admin(System.getProperty("ADMIN_USERNAME"), System.getProperty("ADMIN_PASSWORD"));

    AdminPanelUsers(String username, String password){
        this.username = username;
        this.password = password;
    }

    public final String username;
    public final String password;
}
