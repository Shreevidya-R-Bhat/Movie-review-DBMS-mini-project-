import axios from 'axios';

export default axios.create({
    baseURL:'https://0dfc-2402-e280-2117-e9-d8fb-3592-7e59-4ee1.ngrok-free.app/',
    headers: {"ngrok-skip-browser-warning": "true"}
});