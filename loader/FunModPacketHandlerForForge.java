package FunMod.loader;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Packet250CustomPayload;
import FunMod.enums.EnumFunMod;

public class FunModPacketHandlerForForge
{
    

    public static void sendClientData(EntityPlayer var0, EnumFunMod var1, Object ... var2)
    {
    	EntityPlayer var3 = (EntityPlayer)var0;

        try
        {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            DataOutputStream var5 = new DataOutputStream(new GZIPOutputStream(var4));
            var5.writeInt(var1.ordinal());
            Object[] var6 = var2;
            int var7 = var2.length;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                Object var9 = var6[var8];

                if (var9 != null)
                {
                    if (var9 instanceof Map)
                    {
                        Map var10 = (Map)var9;
                        Iterator var11 = var10.keySet().iterator();

                        while (var11.hasNext())
                        {
                            String var12 = (String)var11.next();
                            int var13 = ((Integer)var10.get(var12)).intValue();
                            var5.writeInt(var13);
                            var5.writeUTF(var12);
                        }
                    }
                    else if (var9 instanceof Enum)
                    {
                        var5.writeInt(((Enum)var9).ordinal());
                    }
                    else if (var9 instanceof Boolean)
                    {
                        var5.writeBoolean(((Boolean)var9).booleanValue());
                    }
                    else if (var9 instanceof Integer)
                    {
                        var5.writeInt(((Integer)var9).intValue());
                    }
                    else if (var9 instanceof String)
                    {
                        var5.writeUTF((String)var9);
                    }
                    else if (var9 instanceof Float)
                    {
                        var5.writeFloat(((Float)var9).floatValue());
                    }
                    else if (var9 instanceof Double)
                    {
                        var5.writeDouble(((Double)var9).doubleValue());
                    }
                    
                }
            }

            var5.close();
            var3.netServerHandler.sendPacket(new Packet250CustomPayload("mod_AnimalBikes", var4.toByteArray()));
        }
        catch (IOException var14)
        {
            var14.printStackTrace();
        }
    }

    public static void sendServerData(EnumFunMod var0, Object ... var1)
    {
        try
        {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            DataOutputStream var3 = new DataOutputStream(new GZIPOutputStream(var2));
            var3.writeInt(var0.ordinal());
            Object[] var4 = var1;
            int var5 = var1.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                Object var7 = var4[var6];

                if (var7 != null)
                {
                    if (var7 instanceof Map)
                    {
                        Map var8 = (Map)var7;
                        Iterator var9 = var8.keySet().iterator();

                        while (var9.hasNext())
                        {
                            String var10 = (String)var9.next();
                            int var11 = ((Integer)var8.get(var10)).intValue();
                            var3.writeInt(var11);
                            var3.writeUTF(var10);
                        }
                    }
                    else if (var7 instanceof Enum)
                    {
                        var3.writeInt(((Enum)var7).ordinal());
                    }
                    else if (var7 instanceof Boolean)
                    {
                        var3.writeBoolean(((Boolean)var7).booleanValue());
                    }
                    else if (var7 instanceof Integer)
                    {
                        var3.writeInt(((Integer)var7).intValue());
                    }
                    else if (var7 instanceof String)
                    {
                        var3.writeUTF((String)var7);
                    }
                    else if (var7 instanceof Float)
                    {
                        var3.writeFloat(((Float)var7).floatValue());
                    }
                    else if (var7 instanceof Double)
                    {
                        var3.writeDouble(((Double)var7).doubleValue());
                    }
                }
            }

            var3.close();
            
        }
        catch (IOException var12)
        {
            var12.printStackTrace();
        }
    }
}
