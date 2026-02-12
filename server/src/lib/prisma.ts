import { PrismaClient } from '@prisma/client';

// Esto evita que se creen múltiples instancias en desarrollo
const globalForPrisma = global as unknown as { prisma: PrismaClient | undefined};

export const prisma = globalForPrisma.prisma ?? new PrismaClient();

if (process.env.NODE_ENV !== 'production') {
    globalForPrisma.prisma = prisma
};
