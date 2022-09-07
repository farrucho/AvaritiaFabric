package net.farrucho.avaritia.block.custom;

import net.farrucho.avaritia.block.entity.ModBlockEntities;
import net.farrucho.avaritia.block.entity.NeutronCollectorBlockEntity;
import net.farrucho.avaritia.block.entity.NeutroniumCompressorBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NeutroniumCompressorBlock extends BlockWithEntity {
    public NeutroniumCompressorBlock(Settings settings) {
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
        return new NeutroniumCompressorBlockEntity(pos,state);
    }


    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;//With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.NEUTRONIUM_COMPRESSOR, (world1, pos, state1, be) -> NeutroniumCompressorBlockEntity.tick(world1, pos, state1, be));//pode ser replaced a lambda reference para ::new
    }



}
