/*    */ package FunMod.items;
/*    */ 
/*    */ import net.minecraft.server.EntityPlayer;
import net.minecraft.server.EnumArmorMaterial;
/*    */ import net.minecraft.server.Item;
/*    */ import net.minecraft.server.ItemArmor;
/*    */ import net.minecraft.server.ItemStack;
/*    */ import net.minecraftforge.common.IArmorTextureProvider;
/*    */ import FunMod.FunMod;
/*    */ public class SonicBoots extends ItemArmor
/*    */   implements IArmorTextureProvider
/*    */ {
/*    */   public SonicBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
/*    */   {
/* 12 */     super(par1, par2EnumArmorMaterial, par3, par4);
/*    */ 
/* 15 */     this.textureId = 25;
/*    */     this.a(FunMod.funmodtab);
}
/*    */ /**
/*       public String getArmorTextureFile(ItemStack par1)
/*       {
/* 21      if ((par1.id == ExtremeMinerios.alexHelmet.id) || (par1.id == ExtremeMinerios.alexPlate.id) || 
/* 22        (par1.id == ExtremeMinerios.alexBoots.id))
/* 23  "/ExtremeMinerios/client/armaduras/alex_1.png";
/* 24/     if (par1.id == ExtremeMinerios.alexBoots.id)
/* 25        return "/ExtremeMinerios/client/armaduras/enx_bo.png";
/* 26      return "/ExtremeMinerios/client/armaduras/alex_2.png";
/*   */   
       public String getTextureFile() {
     return "/FunMod/cliente/texturas/texturas.png";
       }     

@Override
public String getArmorTextureFile(ItemStack par1) {
	 if (par1.id == FunMod.SonicBoots.id)
		        return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
	 return "/FunMod/cliente/texturas/armaduras/sonic_2.png";
}
}

/* Location:           N:\a\
 * Qualified Name:     ExtremeMinerios.ItealexBoots
 * JD-Core Version:    0.6.1
 */