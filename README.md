## 🌊 Ocean Explorer

Ocean Explorer is a web-based grid simulator for a probe that navigates a 2D grid, avoiding obstacles and responding to movement commands. The frontend animates the probe’s movements and updates the direction in real-time.

## 📦 Features

- Send movement commands (`F`, `B`, `L`, `R`) to the probe.
- Simulate obstacles on a configurable grid.
- Real-time animation of probe movement.
- Probe arrow rotates to indicate current direction.
- REST API backend for executing probe commands.

---

## 🛠 Tech Stack

- **Backend:** Spring Boot, Java
- **Frontend:** React, Axios, Tailwind/Custom CSS
- **Testing:** JUnit, MockMvc
- **Build:** Maven

---

## ⚙️ Backend API

### **Execute Probe Commands**

- **URL:** `/api/probe/execute`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Payload Example:**
```json
{
  "startX": 0,
  "startY": 0,
  "direction": "NORTH",
  "commands": "FFRFF",
  "gridWidth": 5,
  "gridHeight": 5,
  "obstacles": [
    {"x":2, "y":2},
    {"x":3, "y":3}
  ]
}
````

* **Response Example:**

```json
{
  "finalX": 2,
  "finalY": 2,
  "direction": "EAST"
}
```

* **Commands:**

  * `F` - Move Forward
  * `B` - Move Backward
  * `L` - Turn Left
  * `R` - Turn Right

* **Notes:**

  * Probe cannot move outside the grid.
  * Probe stops at obstacles.

---

## 🖥 Frontend Usage

### Install Dependencies

```bash
cd frontend
npm install
```

### Run Development Server

```bash
npm start
```

* The app runs on `http://localhost:5174`
* Connects to backend at `http://localhost:8080`

---

### Sending Commands

* Use the **Controls** panel to input start position, direction, commands, grid size, and obstacles.
* Click **Run** to animate the probe across the grid.
* The **Grid** component animates:

  * Probe position
  * Probe direction (arrow rotates accordingly)
  * Obstacles displayed as blocked cells

---

## 🎨 Grid Animation

* **Movement:** Each command executes with a delay for smooth animation.
* **Direction:** Arrow rotates based on the probe's facing direction.
* **Obstacles:** Prevent probe movement and are displayed as red/blocked cells.
* **Customization:** Update `gridSize`, `obstacles`, or `commands` in the frontend form.

---

## 🧪 Testing

### Backend Tests

```bash
mvn test
```

* Integration and unit tests cover probe logic, grid boundaries, and obstacle handling.

### Frontend Tests

* Ensure commands correctly generate the path.
* Animation and direction updates tested visually.

---

## 🔧 Folder Structure

```
ocean-explorer/
├─ backend/                 # Spring Boot backend
│  ├─ src/main/java/
│  ├─ src/test/java/
│  └─ pom.xml
├─ frontend/                # React frontend
│  ├─ src/
│  │  ├─ components/       # Grid, Controls
│  │  └─ App.jsx
│  └─ package.json
└─ README.md
```

---

## ⚡ Tips

* Make sure backend is running before starting frontend.
* Obstacles must be sent as array of `{x, y}` objects for proper parsing.
* Commands are case-sensitive (`F`, `B`, `L`, `R`).
* Increase animation speed by adjusting the `setTimeout` delay in `App.jsx`.

---

## 📌 License

MIT License

Open for contributions too, made with 💓 by Prabhu
