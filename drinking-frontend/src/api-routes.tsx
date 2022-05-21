const api = "/";
const users = api + "user";
const restaurants = api + "restaurant";

//user
export const GET_ALL_USERS = users;
export const GET_ONE_USER = users + "/";
export const POST_USER = users;

//restaurant
export const GET_ALL_RESTAURANTS = restaurants;
export const GET_ONE_RESTAURANT = restaurants + "/";
export const POST_RESTAURANT = restaurants;
export const ADD_DRINK_TO_RESTAURANT = restaurants + "/";