import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import tailwindcss from "@tailwindcss/vite";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react(), tailwindcss()],

  /* to configure build server to custom port. default port from vite is 5173
  server: {
    port: 5000,
  },
  */
});
