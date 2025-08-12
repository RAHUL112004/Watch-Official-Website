package com.example.demo.DTO;



public class Login {

		private long id;
		private String name;
		private String password;
		private String email;
		private long number;
	    
	    
	    public Login(){}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public long getNumber() {
			return number;
		}


		public void setNumber(long number) {
			this.number = number;
		};
	    
}
