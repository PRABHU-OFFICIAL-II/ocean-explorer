import { useState } from "react";

export default function Controls({ onRun }) {
  const [form, setForm] = useState({
    startX: 0,
    startY: 0,
    direction: "NORTH",
    commands: "FFRFF",
    gridWidth: 5,
    gridHeight: 5,
    obstacles: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleRun = () => {
    const obstacleArray = form.obstacles
      ? form.obstacles.split(";").map(o => {
          const [x, y] = o.split(",").map(Number);
          return { x, y };
        })
      : [];

    onRun({
      ...form,
      startX: Number(form.startX),
      startY: Number(form.startY),
      gridWidth: Number(form.gridWidth),
      gridHeight: Number(form.gridHeight),
      obstacles: obstacleArray
    });
  };

  return (
    <div style={{ marginBottom: 20 }}>
      <input name="startX" placeholder="Start X" onChange={handleChange} />
      <input name="startY" placeholder="Start Y" onChange={handleChange} />

      <select name="direction" onChange={handleChange}>
        <option>NORTH</option>
        <option>SOUTH</option>
        <option>EAST</option>
        <option>WEST</option>
      </select>

      <input name="commands" placeholder="Commands (FFRFF)" onChange={handleChange} />
      <input name="gridWidth" placeholder="Grid Size" onChange={handleChange} />
      <input name="obstacles" placeholder="Obstacles (e.g. 2,2;3,3)" onChange={handleChange} />

      <br /><br />
      <button onClick={handleRun}>🚀 Run Probe</button>
    </div>
  );
}