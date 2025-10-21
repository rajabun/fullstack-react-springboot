import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
// import styles from './App.css'

function App() {
  const [count, setCount] = useState(0);
  const logoStyle = {
    height: "6em",
    padding: "1.5em",
    transition: "filter 300ms",
  };

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img
            style={logoStyle}
            src={viteLogo}
            className="logo"
            alt="Vite logo"
          />
        </a>
        <a href="https://react.dev" target="_blank">
          <img
            style={logoStyle}
            src={reactLogo}
            className="logo react"
            alt="React logo"
          />
        </a>
      </div>
      <h1>Vite + React</h1>
      {/* <div className= {`${styles.card}`}> */}
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  );
}

export default App;
