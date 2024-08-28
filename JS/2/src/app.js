//const { envs } = require("./src/config/env");
//const { startServer } = require("./src/server/server");

import { envs } from "./config/env.js";
import { startServer } from "./server/server.js";

const main = () => {
	startServer({
		port: envs.PORT,
		public_path: envs.PUBLIC_PATH,
	});
};

//Funcion async agnostica (NO tiene nombre)
//Autoconvocada porque se ejecuta con los paréntesis
(async () => {
	main();
})();
