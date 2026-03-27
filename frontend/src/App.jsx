import { useState } from "react";
import axios from "axios";
import Grid from "./components/Grid";
import Controls from "./components/Controls";

function App() {
  const [path, setPath] = useState([]);
  const [direction, setDirection] = useState("NORTH");
  const [obstacles, setObstacles] = useState([]);
  const [gridSize, setGridSize] = useState(5);

  const generatePath = (formData, obstacles, gridSize) => {
    let x = formData.startX;
    let y = formData.startY;
    let direction = formData.direction;

    const path = [{ x, y, direction }];

    const isObstacle = (nx, ny) =>
      obstacles.some(o => o.x === nx && o.y === ny);

    const isInside = (nx, ny) =>
      nx >= 0 && ny >= 0 && nx < gridSize && ny < gridSize;

    for (let cmd of formData.commands) {
      let newX = x;
      let newY = y;

      if (cmd === "F") {
        if (direction === "NORTH") newY++;
        if (direction === "SOUTH") newY--;
        if (direction === "EAST") newX++;
        if (direction === "WEST") newX--;
      }

      if (cmd === "B") {
        if (direction === "NORTH") newY--;
        if (direction === "SOUTH") newY++;
        if (direction === "EAST") newX--;
        if (direction === "WEST") newX++;
      }

      if (cmd === "L") {
        direction =
          direction === "NORTH" ? "WEST" :
          direction === "WEST" ? "SOUTH" :
          direction === "SOUTH" ? "EAST" : "NORTH";
      }

      if (cmd === "R") {
        direction =
          direction === "NORTH" ? "EAST" :
          direction === "EAST" ? "SOUTH" :
          direction === "SOUTH" ? "WEST" : "NORTH";
      }

      if (cmd === "F" || cmd === "B") {
        if (isInside(newX, newY) && !isObstacle(newX, newY)) {
          x = newX;
          y = newY;
        }
      }

      path.push({ x, y, direction });
    }

    return path;
  };

  const runProbe = async (formData) => {
    try {
      const formattedObstacles = (formData.obstacles || []).map(o => {
        if (typeof o === "string") {
          const [x, y] = o.split(",");
          return [Number(x), Number(y)];
        }
        return [o.x, o.y];
      });

      const payload = {
        ...formData,
        obstacles: formattedObstacles
      };

      console.log("🚀 Sending payload:", payload);

      const res = await axios.post(
        "http://localhost:8080/api/probe/execute",
        payload
      );

      console.log("✅ Response:", res.data);

      setDirection(res.data.direction);
      const uiObstacles = formattedObstacles.map(([x, y]) => ({ x, y }));
      const fullPath = generatePath(formData, uiObstacles, formData.gridWidth);

      fullPath.forEach((point, index) => {
        setTimeout(() => {
          setPath([{ x: point.x, y: point.y }]);
          setDirection(point.direction);
        }, index * 400);
      });

      setObstacles(
        formattedObstacles.map(([x, y]) => ({ x, y }))
      );
      setGridSize(formData.gridWidth);

    } catch (err) {
      console.error("🔥 Backend error:", err.response?.data);
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>🌊 Ocean Explorer</h1>

      <Controls onRun={runProbe} />

      <Grid
        path={path}
        obstacles={obstacles}
        size={gridSize}
        direction={direction}
      />
    </div>
  );
}

export default App;