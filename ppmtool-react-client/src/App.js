import "./App.css";
import Dashboard from "./component/Dashboard";
import Header from "./component/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./component/Project/AddProject";
import {Provider} from "react-redux"; //how we define the store that we're going to use
import store from "./store";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/addProject" component={AddProject} />
        </div>
      </Router>
    </Provider>
  );
}

export default App;
