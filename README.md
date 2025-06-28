# 🧾 POTS — Purchase Order Tracking System
A role-based Java application for efficiently managing inventory, sales, procurement, and finance operations within an organization

## 🔍 Overview
POTS is a multi-role system designed to coordinate the activities of Sales, Inventory, Purchase, and Finance departments through a centralized, user-specific interface. The application enforces role-based access control, ensuring that each stakeholder interacts with only the functionalities relevant to their responsibilities.

## 👥 User Roles and Functionalities
### 1. 🛒 Sales Manager (SM)
Responsible for managing product sales and generating requisitions based on stock levels.
Access Rights:
- View list of items
- Enter daily item-wise sales data (Add / Save / Edit / Delete)
- Generate sales reports
- Monitor current stock levels
- Create requisitions for items below reorder level
- View all purchase orders

### 2. 📦 Purchase Manager (PM)
Handles procurement based on requisitions initiated by the Sales Manager.
Access Rights:
- View list of items and suppliers
- Access and review sales manager requisitions
- Generate, modify, or delete purchase orders
- View all purchase orders

### 3. 🏷️ Inventory Manager (IM)
Maintains item and supplier records and updates stock upon receipt.
Access Rights:
- Manage item entries (Add / Edit / Delete / Modify)
- Manage supplier entries (Add / Edit / Delete / Modify)
- Monitor and view current stock levels
- Update stock status after receiving items
- Edit stock data as necessary

### 4. 💰 Finance Manager (FM)
Oversees purchase order approval and supplier payments.
Access Rights:
- View and verify purchase orders for approval or rejection
- Check current stock status of ordered items
- Make payments and update purchase order statuses
- Track supplier payment history and payment statuses

### 5. 🛠️ Administrator (AM)
Full system access and user role management.
Access Rights:
- Full control over all data and system modules
- Authorize and register users in all five roles:
- Sales Manager
- Purchase Manager
- Inventory Manager
- Finance Manager
- Other Administrators

