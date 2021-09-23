import Home from "./components/Home";
import Player from "./components/Player";
import Team from "./components/Team";

const routes = [
    {
        path: "/home",
        exact: true,
        component: Home,
        strict: true,
    },
    {
        path: "/team",
        exact: true,
        component: Team,
        strict: true,
    },
    {
        path: "/player",
        exact: true,
        component: Player,
        strict: true,
    },
];

export default routes;
