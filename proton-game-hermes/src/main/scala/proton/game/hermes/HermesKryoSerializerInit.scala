package proton.game.hermes

import java.util.UUID

import com.esotericsoftware.kryo.io.{Input, Output}
import com.esotericsoftware.kryo.{Kryo, Serializer}
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer
import proton.game._

class HermesKryoSerializerInit {
  def customize(kryo: Kryo): Unit  = {
    kryo.setDefaultSerializer(classOf[TaggedFieldSerializer[_]])

    kryo.register(classOf[UUID], new Serializer[UUID] {
      override def write(kryo: Kryo, output: Output, uuid: UUID): Unit = {
        output.writeLong(uuid.getMostSignificantBits, false)
        output.writeLong(uuid.getLeastSignificantBits, false)
      }

      override def read(kryo: Kryo, input: Input, `type`: Class[UUID]): UUID =
        new UUID(input.readLong(false), input.readLong(false))
    }, 20)

    kryo.register(classOf[Envelope], 21)
    kryo.register(classOf[Validation], 22)
    kryo.register(classOf[ValidationException], 23)
    kryo.register(classOf[Message], 24)
    kryo.register(classOf[HermesGameMessage.GetStatus], 25)
    kryo.register(classOf[HermesGameMessage.GetState], 26)
    kryo.register(classOf[HermesGameMessage.GetPlayer], 27)
    kryo.register(classOf[HermesGameMessage.Configure], 28)
    kryo.register(classOf[HermesGameMessage.Join], 29)
    kryo.register(classOf[HermesGameMessage.Play], 30)
    kryo.register(classOf[HermesGameMessage.Start], 31)
    kryo.register(classOf[HermesGameMessage.Stop], 32)
    kryo.register(classOf[HermesGameMessage.Clear], 33)
    kryo.register(classOf[HermesGameMessage.Transition], 34)
    kryo.register(classOf[HermesGameMessage.Timeout], 35)
    kryo.register(classOf[HermesGameMessage.Configured], 36)
    kryo.register(classOf[HermesGameMessage.Joined], 37)
    kryo.register(classOf[HermesGameMessage.Played], 38)
    kryo.register(classOf[HermesGameMessage.Started], 39)
    kryo.register(classOf[HermesGameMessage.Stopped], 40)
    kryo.register(classOf[HermesGameMessage.Cleared], 41)
    kryo.register(classOf[HermesGameMessage.Transitioned], 42)
    kryo.register(classOf[HermesGameMessage.TimedOut], 43)
    kryo.register(classOf[HermesGameMessage.StatusResult], 44)
    kryo.register(classOf[HermesGameMessage.ConfiguredResult], 45)
    kryo.register(classOf[HermesGameMessage.StateResult], 46)
    kryo.register(classOf[HermesGameMessage.PlayerResult], 47)
    kryo.register(classOf[HermesGameMessage.PlayerJoinedResult], 48)
    kryo.register(classOf[HermesGameMessage.PlayedResult], 49)
    kryo.register(classOf[HermesGameMessage.StartedResult], 50)
    kryo.register(classOf[HermesGameMessage.StoppedResult], 51)
    kryo.register(classOf[HermesGameMessage.ClearedResult], 52)
    kryo.register(classOf[HermesGameMessage.GameNotifyJoined], 53)
    kryo.register(classOf[HermesGameMessage.GameNotifyStarted], 54)
    kryo.register(classOf[HermesGameMessage.GameNotifyStopped], 55)
    kryo.register(classOf[HermesGameMessage.GameNotifyCleared], 56)
    kryo.register(classOf[HermesGameMessage.GameNotifyTransitioned], 57)
    kryo.register(classOf[HermesGameMessage.GameNotifyTimedOut], 58)
    kryo.register(classOf[HermesGameMessage.GameNotifyCompleted], 59)
    kryo.register(classOf[HermesGameMessage.PlayerGamePublicState], 60)
    kryo.register(classOf[HermesGameMessage.PlayerGamePrivateState], 61)
    kryo.register(classOf[HermesGameMessage.GameState], 62)
    kryo.register(classOf[HermesGameMessage.GameServerHandlerResponseMessage], 63)
    kryo.register(classOf[GameMeta], 64)
    kryo.register(classOf[GameServerHandler.GameServerHandlerMode.Value], 65)
    kryo.register(classOf[GameServerHandler.GameServerHandlerResponseType.Value], 66)
    kryo.register(classOf[GameServerHandler.PlayerAuth], 67)
    kryo.register(classOf[GameServerHandler.Initialize], 68)
    kryo.register(classOf[GameTickerModule.GameTickerMessageName], 69)
    kryo.register(classOf[PlayerIdentity], 70)
    kryo.register(classOf[ChunkedHermesGameFileMediator.GetChunkEntries], 71)
    kryo.register(classOf[ChunkedHermesGameFileEntries.AppendEntries], 72)
    kryo.register(classOf[ChunkedHermesGameFileEntries.GetEntries], 73)
    kryo.register(classOf[ChunkedHermesGameFileEntries.EntriesAppended], 74)
    kryo.register(classOf[ChunkedHermesGameFileEntries.EntriesAppendedResult], 75)
    kryo.register(classOf[ChunkedHermesGameFileEntries.GetEntriesResult], 76)
    kryo.register(classOf[ChunkedHermesGameFileRepositoryMediator.GetGameFileById], 77)
    kryo.register(classOf[ChunkedHermesGameFiles.CreateGameFile], 78)
    kryo.register(classOf[ChunkedHermesGameFiles.ChangeGameFileSettings], 79)
    kryo.register(classOf[ChunkedHermesGameFiles.InitialGameFileEntries], 80)
    kryo.register(classOf[ChunkedHermesGameFiles.AppendGameFileEntries], 81)
    kryo.register(classOf[ChunkedHermesGameFiles.ReplaceGameFileEntries], 82)
    kryo.register(classOf[ChunkedHermesGameFiles.MarkGameFileComplete], 83)
    kryo.register(classOf[ChunkedHermesGameFiles.GetGameFileDetails], 84)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileCreated], 85)
    kryo.register(classOf[ChunkedHermesGameFiles.ChangedGameFileSettings], 86)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileEntriesChanged], 87)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileCompleted], 88)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileCreatedResult], 89)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileChangeSettingsResult], 90)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileEntriesChangedResult], 91)
    kryo.register(classOf[ChunkedHermesGameFiles.GameFileCompletedResult], 92)
    kryo.register(classOf[ChunkedHermesGameFiles.GetGameFileDetailsResult], 93)
    kryo.register(classOf[HermesGameTier.Value], 94)
    kryo.register(classOf[HermesGameRegion.Value], 95)
    kryo.register(classOf[HermesGameResearch.Value], 96)
    kryo.register(classOf[HermesGameUpgrade.Value], 97)
    kryo.register(classOf[HermesGameServerAdjustment], 98)
    kryo.register(classOf[AdjustServers], 99)
    kryo.register(classOf[ApplyResearch], 100)
    kryo.register(classOf[Upgrade], 101)
    kryo.register(classOf[HermesGameFileEntry], 102)
    kryo.register(classOf[HermesGameFileSettings], 103)
    kryo.register(classOf[HermesGamePublicState], 104)
    kryo.register(classOf[HermesGameServerFailoverState], 105)
    kryo.register(classOf[HermesGameServerCapacityState], 106)
    kryo.register(classOf[HermesGameServerPerformanceState], 107)
    kryo.register(classOf[HermesGameServerChangeState], 108)
    kryo.register(classOf[HermesGameServerRegionState], 109)
    kryo.register(classOf[HermesGameServerTierState], 110)
    kryo.register(classOf[HermesGameAppliedUpgradeState], 111)
    kryo.register(classOf[HermesGamePrivateState], 112)
    kryo.register(classOf[HermesGameUpgradeState], 113)
    kryo.register(classOf[HermesGameResearchState], 114)
    kryo.register(classOf[HermesSharedState], 115)
    kryo.register(classOf[HermesGameTickerModule.AdvertisementDefinition], 116)
    kryo.register(classOf[HermesGameTickerModule.AdvertisementNameChange], 117)
    kryo.register(classOf[HermesGameTickerModule.AdvertisementVisibilityChange], 118)
    kryo.register(classOf[HermesGameTickerModule.GameFileCompleteChange], 119)
    kryo.register(classOf[HermesGameTickerModulePerRequest.CreateAdvertisementRequest], 120)
    kryo.register(classOf[HermesGameTickerModulePerRequest.SearchVisibleFilesRequest], 121)
    kryo.register(classOf[HermesGameTickerModulePerRequest.SearchFilesRequest], 122)
    kryo.register(classOf[HermesGameTickerModulePerRequest.GetFileRequestById], 123)
    kryo.register(classOf[HermesGameTickerModulePerRequest.DeleteFileRequest], 124)
    kryo.register(classOf[HermesGameTickerModulePerRequest.ChangeFileNameRequest], 125)
    kryo.register(classOf[HermesGameTickerModulePerRequest.SetFileVisibilityRequest], 126)
    kryo.register(classOf[HermesGameTickerModulePerRequest.SetFileCompleteRequest], 127)
    kryo.register(classOf[HermesGameTickerModulePerRequest.AddFileEntriesRequest], 128)
    kryo.register(classOf[HermesGameTickerModulePerRequest.GetFileEntriesRequestById], 129)
    kryo.register(classOf[HermesGameTickerModulePerRequest.HermesGameFileAdvertisementResult], 130)
    kryo.register(classOf[HermesGameTickerModulePerRequest.HermesGameTickerModulePerRequestGetResults], 131)
    kryo.register(classOf[HermesGameTickerModulePerRequest.HermesGameTickerModulePerRequestGetEntriesResults], 132)
    kryo.register(classOf[HermesGameTickerModulePerRequest.HermesGameTickerModulePerRequestDeleteResult], 133)
    kryo.register(classOf[HermesGameTickerModulePerRequest.HermesGameTickerModulePerRequestDetailsResult], 134)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AddAdvertisement], 135)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.SetAdvertisementVisibility], 136)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.ChangeAdvertisementName], 137)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.RemoveAdvertisement], 138)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.GetAdvertisementByName], 139)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.GetAdvertisementById], 140)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.GetAllAdvertisements], 141)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementAdded], 142)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementShown], 143)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementHidden], 144)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementNameChanged], 145)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementRemoved], 146)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementAddedResult], 147)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementVisibilitySetResult], 148)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementChangeNameResult], 149)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.AdvertisementRemoveResult], 150)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.GetAdvertisementResult], 151)
    kryo.register(classOf[SingletonHermesGameFileAdvertisements.GetAdvertisementsResult], 152)
  }
}
