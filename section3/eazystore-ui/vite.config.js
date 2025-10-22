import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],

  /* to configure build server to custom port. default port from vite is 5173
  server: {
    port: 5000,
  },
  */
});
