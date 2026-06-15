import { Route, Routes } from "react-router";
import { BrowserRouter } from "react-router";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Missing from "./pages/Missing";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
        </Route>

        <Route path="*" element={<Missing />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
