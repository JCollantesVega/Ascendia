import type { Request, Response } from "express";
import { prisma } from "../lib/prisma.js";


export const getMentors = async(req: Request, res: Response) => {
    try{
        const mentors = await prisma.mentorProfile.findMany({
            include:{
                user:{
                    select:{
                        username: true,
                        avatarUrl: true,
                    }
                }
            }
        });

        const formattedMentors = mentors.map(m => ({
            id: m.id,
            name: m.user.username,
            avatarUrl: m.user.avatarUrl,
            speciality: m.specialities,
            price: m.priceHour,
        }));

        res.json(formattedMentors);
    }catch(error) {
        res.status(500).json({error: "Error al obtener mentores"});
    }
};