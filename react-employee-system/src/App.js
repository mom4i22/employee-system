import { Fragment } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import AddEmployee from "./components/AddEmployee";
import EditEmployee from "./components/EditEmployee";
import EmployeesList from "./components/EmployeesList";
import Navbar from "./components/Navbar";

function App() {
  return (
    <Fragment>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<EmployeesList />} />
          <Route path="index" element={<EmployeesList />} />
          <Route path="/employeeList" element={<EmployeesList />} />
          <Route path="/addEmployee" element={<AddEmployee />} />
          <Route path="/editEmployee/:id" element={<EditEmployee />} />
        </Routes>
      </BrowserRouter>
    </Fragment>
  );
}

export default App;
