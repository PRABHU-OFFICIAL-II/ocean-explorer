import { useEffect, useState } from "react";

const getArrow = (direction) => {
  switch (direction) {
    case "NORTH": return "↑";
    case "SOUTH": return "↓";
    case "EAST": return "→";
    case "WEST": return "←";
    default: return "•";
  }
};

export default function Grid({ path, obstacles, size, direction }) {
  const [currentIndex, setCurrentIndex] = useState(0);

  // Animate movement
  useEffect(() => {
    if (path.length === 0) return;

    setCurrentIndex(0);

    const interval = setInterval(() => {
      setCurrentIndex((prev) => {
        if (prev >= path.length - 1) {
          clearInterval(interval);
          return prev;
        }
        return prev + 1;
      });
    }, 400); // speed of animation

    return () => clearInterval(interval);
  }, [path]);

  return (
    <div>
      {Array.from({ length: size + 1 }).map((_, y) => (
        <div key={y} style={{ display: "flex", justifyContent: "center" }}>
          {Array.from({ length: size + 1 }).map((_, x) => {
            const realY = size - y;

            const isVisited = path
              .slice(0, currentIndex + 1)
              .some(p => p.x === x && p.y === realY);

            const isObstacle = obstacles.some(o => o.x === x && o.y === realY);

            const isCurrent =
              path[currentIndex]?.x === x &&
              path[currentIndex]?.y === realY;

            return (
              <div
                key={x}
                style={{
                  width: 45,
                  height: 45,
                  border: "1px solid black",
                  backgroundColor: isObstacle
                    ? "red"
                    : isCurrent
                    ? "yellow"
                    : isVisited
                    ? "lightblue"
                    : "white",
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "center",
                  fontSize: 20,
                  fontWeight: "bold"
                }}
              >
                {isCurrent ? getArrow(direction) : ""}
              </div>
            );
          })}
        </div>
      ))}
    </div>
  );
}