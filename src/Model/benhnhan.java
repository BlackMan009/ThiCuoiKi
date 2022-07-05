package Model;

import java.util.Date;

public class benhnhan {
        private String id,name,phone,type,room,department,bed,address;
        private Date birthday,dayin;
        public benhnhan() {
			super();
		}

		public benhnhan(String id, String name, String phone, Date birthday, Date dayin, String type, String room,
				String department, String bed, String address) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.birthday = birthday;
			this.dayin = dayin;
			this.type = type;
			this.room = room;
			this.department = department;
			this.bed = bed;
			this.address = address;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public Date getDayin() {
			return dayin;
		}

		public void setDayin(Date dayin) {
			this.dayin = dayin;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getRoom() {
			return room;
		}

		public void setRoom(String room) {
			this.room = room;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getBed() {
			return bed;
		}

		public void setBed(String bed) {
			this.bed = bed;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	
}
