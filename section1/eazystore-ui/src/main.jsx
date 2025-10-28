import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";

// StrictMode is used for render the view two times to find bugs in early development.
// It's only executed in development environment
createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>
);
