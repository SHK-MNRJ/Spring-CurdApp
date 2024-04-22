package com.SpringCrud.SpringApplication.DTO;

public class CustomerUpdateDTO {
		private int customerid;
		
		private String customername;
		
		private String customeraddress;
		
		private int mobile;
		
		public CustomerUpdateDTO(int customerid,String customername,String customeraddress,int mobile) {
			this.setCustomerid(customerid);
			this.setCustomername(customername);
			this.setCustomeraddress(customeraddress);
			this.setMobile(mobile);
		}
		
		public CustomerUpdateDTO() {
		}
		
		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public String getCustomeraddress() {
			return customeraddress;
		}

		public void setCustomeraddress(String customeraddress) {
			this.customeraddress = customeraddress;
		}

		public int getMobile() {
			return mobile;
		}

		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
		
		
		@Override
		public String toString() {
			return "Customer{"+
					", customername='"+customername+'\''+
					", customeraddress='"+customeraddress+'\''+
					", mobile="+mobile+
					'}';
		
		}

		public int getCustomerid() {
			return customerid;
		}

		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}

}
