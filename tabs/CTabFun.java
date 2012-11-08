package FunMod.tabs;

import net.minecraft.server.CreativeModeTab;
import FunMod.FunMod;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class CTabFun extends CreativeModeTab {
	public CTabFun(int par1, String par2Str) {
super(par1, par2Str);

}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return FunMod.Starman.id;
}

}
