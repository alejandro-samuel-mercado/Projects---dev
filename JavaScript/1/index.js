//const { getTitle, getAuthor } = require('./functions');
// const {curso}=require('./objects)
import { getTitle, getAuthor } from "./functions.js";
import { curso } from "./objects.js";
import { config } from "dotenv";
config();

const { nombre, autor } = curso;

console.log(getAuthor("Aleee"));
console.log(getTitle);
console.log(nombre);
console.log(autor);

console.log(process.env.PORT); //Obtiene y muestra el puerto de entorno
