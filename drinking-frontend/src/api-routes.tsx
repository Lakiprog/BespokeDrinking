const api = "/";
const users = api + "user";
const restaurants = api + "restaurant";
const questions = api + "question";
const drinks = api + "drink";

//user
export const GET_ALL_USERS = users;
export const GET_ONE_USER = users + "/";
export const HAS_FILLED_USER = users + "/hasFilled/";
export const POST_USER = users;
export const ADD_USER_ALLERGIES = users + "/";

//restaurant
export const GET_ALL_RESTAURANTS = restaurants;
export const GET_ONE_RESTAURANT = restaurants + "/";
export const POST_RESTAURANT = restaurants;
export const ADD_DRINK_TO_RESTAURANT = restaurants + "/";
export const GET_BEST_RESTAURANT = restaurants + "/getBestRestaurant";

//questions
export const ANSWER_QUESTION = questions + "/addAnsweredQuestion/";

// drinks
export const GET_BEST_DRINKS = drinks + "/getBestDrinks/";
