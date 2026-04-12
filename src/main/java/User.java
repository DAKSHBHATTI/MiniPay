public class User {
    private long userId;
    private String name;
    private String email;
    private boolean isActive;
    public User(long userId,String name,String email){
        this.userId=userId;
        this.name=name;
        this.email=email;
        isActive=true;
    }
    public long getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public boolean IsActive(){
        return isActive;
    }
    public void setActive(boolean isActive){
        this.isActive=isActive;
    }
    @Override
    public String toString(){
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                '}';
    }

}
