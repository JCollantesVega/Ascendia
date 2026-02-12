import express from "express";
import cors from 'cors';
import mentorRoutes from "./routes/mentor.routes.ts";
import 'dotenv/config';

const app = express();

app.use(cors());
app.use(express.json());

//rutas
app.use('/api/v1/mentors', mentorRoutes);


const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Listening on  http://localhost:${PORT}`);
})