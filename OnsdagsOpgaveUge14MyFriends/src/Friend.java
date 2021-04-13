public class Friend {
  private String name;
  private String phone;
  private String email;

  public Friend(String name, String phone, String email) {
    setName(name);
    setPhone(phone);
    setEmail(email);
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }
  public String getPhone() {
    return phone;
  }
  public String getEmail() {
    return email;
  }

  public String toString() {
    return name + "#" + phone + "#" + email;
  }
}
