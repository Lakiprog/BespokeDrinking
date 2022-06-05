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
export const SEARCH_FILTER_RESTAURANTS = restaurants + "/searchAndFilter";

//questions
export const ANSWER_QUESTION = questions + "/addAnsweredQuestion/";
export const CREATE_NEW_QUESTION = questions + "/createNewQuestion";
export const GET_CREATED_UNANSWERED_QUESTIONS =
	questions + "/getUnansweredCreatedQuestions/";

// drinks
export const GET_BEST_DRINKS = drinks + "/getBestDrinks/";
export const GET_ALL_DRINKS = drinks;
export const SEARCH_FILTER_DRINKS = drinks + "/searchAndFilter";
