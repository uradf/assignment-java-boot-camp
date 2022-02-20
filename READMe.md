
## Scenario
* [X] User กดเรียกดูสินค้า โดยระบบจะแสดงสินค้าหน้าละ 5 ชิ้น
* [X] User กดดูสินค้าหน้าที่ 2
* [X] User ไม่เจอสินค้าที่ต้องการ เลยทำการค้นหาสินค้าจากชื่อ โดยใส่คำว่า Tank
* [X] System แสดงสินค้าที่ชื่อว่า Tank (ชื่อ และ ราคา)
* [X] User ทำการหยิบสินค้าชิ้นนี้ใส่ตะกร้า แต่ระบบบังคับให้เข้าสู่ระบบ
* [X] (User ทำการเข้าระบบ)
* [X] User ทำการหยิบสินค้าชิ้นนี้ใส่ตะกร้า
* User กดสั่งซื้อสินค้า
* System แสดงรายละเอียดการสั่งซื้อ
* User เลือก Payment method ด้วย BTC address และ ยืนยันการสั่งซื้อ
* System ทำการตัด BTC กับระบบภายนอก
* System แสดงใบเสร็จ


## API
> GET &nbsp;&nbsp;&nbsp;&nbsp; /products?page=0 &nbsp;&nbsp;&nbsp;&nbsp; ดึง Product ทีละ 5 ชิ้น

> GET &nbsp;&nbsp;&nbsp;&nbsp; /products/by?name= &nbsp;&nbsp;&nbsp;&nbsp; ดึง Product ทีละ 5 ชิ้น ตามชื่อ Product

> POST &nbsp;&nbsp;&nbsp;&nbsp; /auth &nbsp;&nbsp;&nbsp;&nbsp; สำหรับดึง FakeJWTToken

> GET &nbsp;&nbsp;&nbsp;&nbsp; /getAddress &nbsp;&nbsp;&nbsp;&nbsp; สำหรับดึงข้อมูล User (FakeJWTToken is required.)

> GET &nbsp;&nbsp;&nbsp;&nbsp; /cart &nbsp;&nbsp;&nbsp;&nbsp; สำหรับดึงข้อมูล Cart (FakeJWTToken is required.)

> POST &nbsp;&nbsp;&nbsp;&nbsp; /cart &nbsp;&nbsp;&nbsp;&nbsp; สำหรับเพิ่มสินค้าลง Cart (FakeJWTToken is required.) 

> GET &nbsp;&nbsp;&nbsp;&nbsp; /getBalance/{addr}/{deviceKeyStore} &nbsp;&nbsp;&nbsp;&nbsp; สำหรับดึงข้อมูลจำนวน BTC ใน address นั้นๆ

## Constant

userId >> prayut

password >> P@ssw0rd1

FakeJWTToken >> ใช้ header ชื่อ e-com โดยมี value เป็น prayut.VALID_TOKEN_STRING
