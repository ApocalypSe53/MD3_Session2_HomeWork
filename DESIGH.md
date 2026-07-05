# Thiết kế Kiến trúc RESTful API - Hệ thống Quản lý Task & User

## 1. Lấy toàn bộ danh sách công việc, người dùng
* **Lấy danh sách tất cả người dùng:**
  * **Method:** `GET`
  * **Endpoint:** `/api/users`
  * **Mô tả:** Trả về danh sách mảng JSON chứa thông tin của toàn bộ người dùng.
* **Lấy danh sách tất cả công việc:**
  * **Method:** `GET`
  * **Endpoint:** `/api/tasks`
  * **Mô tả:** Trả về danh sách mảng JSON chứa thông tin của toàn bộ công việc.

## 2. Tạo mới công việc, tạo mới người dùng
* **Tạo mới người dùng:**
  * **Method:** `POST`
  * **Endpoint:** `/api/users`
  * **Dữ liệu nhận vào (@RequestBody):**
    ```json
    {
      "name": "Nguyen Van A",
      "email": "a.nguyen@example.com",
      "role": "USER"
    }
    ```
* **Tạo mới công việc:**
  * **Method:** `POST`
  * **Endpoint:** `/api/tasks`
  * **Dữ liệu nhận vào (@RequestBody):**
    ```json
    {
      "title": "Soạn tài liệu hướng dẫn",
      "priority": "medium",
      "status": "pending",
      "userId": 1
    }
    ```

## 3. Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng
* **Cập nhật vai trò của người dùng:**
  * **Method:** `PATCH`
  * **Endpoint:** `/api/users/{id}/role`
  * **Dữ liệu nhận vào (@RequestBody):**
    ```json
    {
      "role": "ADMIN"
    }
    ```
* **Cập nhật trạng thái một công việc:**
  * **Method:** `PATCH`
  * **Endpoint:** `/api/tasks/{id}/status`
  * **Dữ liệu nhận vào (@RequestBody):**
    ```json
    {
      "status": "completed"
    }
    ```

## 4. Xóa một công việc, xóa một người dùng khỏi hệ thống
* **Xóa một người dùng:**
  * **Method:** `DELETE`
  * **Endpoint:** `/api/users/{id}`
  * **Mô tả:** Xóa người dùng theo ID tương ứng khỏi cơ sở dữ liệu.
* **Xóa một công việc:**
  * **Method:** `DELETE`
  * **Endpoint:** `/api/tasks/{id}`
  * **Mô tả:** Xóa công việc theo ID tương ứng khỏi cơ sở dữ liệu.

## 5. Tìm các công việc có mức độ ưu tiên là "high"
* **Method:** `GET`
* **Endpoint:** `/api/tasks?priority=high`
* **Mô tả:** Sử dụng Query Parameter (`priority`) để lọc ra các công việc có độ ưu tiên cao.

## 6. Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1
* **Cách thiết kế chuẩn (Lọc theo đa tham số):**
  * **Method:** `GET`
  * **Endpoint:** `/api/tasks?userId=1&priority=high`
* **Cách thiết kế thay thế (Theo mô hình Sub-resource):**
  * **Method:** `GET`
  * **Endpoint:** `/api/users/1/tasks?priority=high`
  * **Mô tả:** Kết hợp giữa Path Variable (`userId = 1`) và Query Parameter (`priority = high`) để truy vấn chính xác dữ liệu mong muốn.

## 7. Liệt kê toàn bộ công việc của 1 người dùng
* **Method:** `GET`
* **Endpoint:** `/api/users/{userId}/tasks`
* **Mô tả:** Định dạng Sub-resource thể hiện rõ mối quan hệ một-nhiều (1 User có nhiều Tasks), trả về toàn bộ danh sách công việc thuộc về `userId` được chỉ định trên URL.

## 8. Gắn công việc cho người dùng
* **Method:** `PATCH`
* **Endpoint:** `/api/tasks/{id}/assignee`
* **Dữ liệu nhận vào (@RequestBody):**
  ```json
  {
    "userId": 2
  }
