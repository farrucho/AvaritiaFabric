package net.farrucho.avaritia.block.custom;

import net.farrucho.avaritia.block.entity.ExtremeCraftingTableBlockEntity;
import net.farrucho.avaritia.block.entity.ModBlockEntities;
import net.farrucho.avaritia.block.entity.NeutronCollectorBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExtremeCraftingTableBlock extends BlockWithEntity {
    public ExtremeCraftingTableBlock(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            //This will call the createScreenHandlerFactory method from BlockWithEntity, which will return our blockEntity casted to
            //a namedScreenHandlerFactory. If your block class does not extend BlockWithEntity, it needs to implement createScreenHandlerFactory.
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                //With this call the server will request the client to open the appropriate Screenhandler
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ExtremeCraftingTableBlockEntity(pos,state);
    }


    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;//With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.EXTREME_CRAFTING_TABLE, (world1, pos, state1, be) -> ExtremeCraftingTableBlockEntity.tick(world1, pos, state1, be));//pode ser replaced a lambda reference para ::new
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        /*if(world.getBlockEntity(pos) != null){
            NeutronCollectorBlockEntity be = (NeutronCollectorBlockEntity) world.getBlockEntity(pos);
            int i = 0;
            if(be != null){
                DefaultedList<ItemStack> list = be.getItems();
                for(i = 0; i < list.size(); i++){
                    dropStack(world, pos, list.get(i));
                }
            }
        }*/

        super.onBreak(world, pos, state, player);
    }
}
