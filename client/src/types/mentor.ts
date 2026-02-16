export interface MentorProfile{
    id: string;
    bio: string;
    speciality: string[];
    priceHour: number;
    timezone: string;
}


export interface MentorCardProps{
    id: string;
    name: string;
    avatarUrl?: string;
    speciality: string[];
    price: number;
}

export interface MentorGridProps{
    mentors: MentorCardProps[];
}