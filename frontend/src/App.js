import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import routes from "./routes";
import Navbar from "./components/common/Navbar";

function App() {
    return (
        <Router>
            <Switch>
                {routes.map((route, index) => {
                    return (
                        <Route
                            key={index}
                            path={route.path}
                            render={() => {
                                return (
                                    <>
                                        <Navbar />
                                        <route.component />
                                    </>
                                );
                            }}
                        />
                    );
                })}
            </Switch>
        </Router>
    );
}

export default App;
